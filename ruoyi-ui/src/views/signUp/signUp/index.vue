<template>
  <div>
    <div>
      <h1 class="page-title">报名信息</h1>
    <div class="form-container">
    <el-row :gutter="15">
      <el-form ref="courseSelectForm" :model="courseSelectData" :rules="rules" size="medium"
               label-width="100px">
        <el-row :gutter="15">
          <el-col :span="12">
          <el-form-item label="身份证号" prop="studentId">
            <el-input v-model="courseSelectData.studentId" placeholder="请输入您的身份证号" show-word-limit clearable
                      prefix-icon='el-icon-postcard' :style="{width: '90%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="姓名" prop="studentName">
            <el-input v-model="courseSelectData.studentName" placeholder="请输入姓名" clearable
                      prefix-icon='el-icon-user' :style="{width: '80%'}"></el-input>
          </el-form-item>
        </el-col>
        </el-row>
        <el-row :gutter="15">
          <el-col :span="12">
          <el-form-item label="手机号" prop="studentPhone">
            <el-input v-model="courseSelectData.studentPhone" placeholder="请输入手机号" :maxlength="11"
                      show-word-limit clearable prefix-icon='el-icon-mobile' :style="{width: '90%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱" prop="studentEmail">
            <el-input v-model="courseSelectData.studentEmail" placeholder="请输入邮箱" clearable
                      prefix-icon='el-icon-chat-line-round' :style="{width: '80%'}"></el-input>
          </el-form-item>
        </el-col>
        </el-row>
        <el-row :gutter="15">
          <el-col :span="12">
          <el-form-item label="学历" prop="education">
            <el-select v-model="courseSelectData.education" placeholder="请选择学历" clearable
                       :style="{width: '90%'}">
              <el-option v-for="(item, index) in educationOptions" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="单位" prop="unit">
            <el-input v-model="courseSelectData.unit" placeholder="若无所属请填‘个人’" clearable
                      prefix-icon='el-icon-office-building' :style="{width: '80%'}"></el-input>
          </el-form-item>
        </el-col>
        </el-row>
        <el-row :gutter="15">
          <el-col :span="12">
          <el-form-item label="日期范围" prop="dateRange">
            <el-date-picker type="daterange" v-model="courseSelectData.dateRange" format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd" :style="{width: '90%'}" start-placeholder="开始日期"
                            end-placeholder="结束日期" range-separator="至" clearable @change="handleDateRangeChange"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="课程选择" prop="courseId">
            <el-select v-model="courseSelectData.courseId" placeholder="请选择课程" filterable clearable
                       :style="{width: '80%'}">
              <el-option v-for="(item, index) in courseOptions" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        </el-row>
        <el-col :span="24">
          <el-form-item size="large" class="button-container">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
      </div>
    </div>
  </div>
</template>

<script>
import { searchSuitableCourse,signUp} from "@/api/signUp/signUp";

export default {
  components: {},
  props: [],
  data() {
    return {
      courseSelectData: {
        studentId: undefined,
        dateRange: [],
        courseId: undefined,
        studentName: undefined,
        studentPhone: '',
        studentEmail: undefined,
        education: '',
        unit: '',
      },
      rules: {
        studentId: [{
          required: true,
          message: '请输入您的身份证号',
          trigger: 'blur'
        }],
        dateRange: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
        courseId: [{
          required: true,
          message: '请选择课程',
          trigger: 'change'
        }],
        studentName: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        studentPhone: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        studentEmail: [{
          required: true,
          message: '请输入邮箱',
          trigger: 'blur'
        }, {
          pattern: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
          message: '邮箱格式错误',
          trigger: 'blur'
        }],
        education: [{
          required: true,
          message: '请选择学历',
          trigger: 'change'
        }],
        unit: [{
          required: true,
          message: '若无所属请填‘个人’',
          trigger: 'blur'
        }],
      },
      courseOptions: [],
      educationOptions: [{
        "label": "小学",
        "value": "小学"
      }, {
        "label": "初中",
        "value": "初中"
      }, {
        "label": "高中/职中/中专",
        "value": "高中/职中/中专"
      }, {
        "label": "大专",
        "value": "大专"
      }, {
        "label": "本科",
        "value": "本科"
      }, {
        "label": "硕士",
        "value": "硕士"
      }, {
        "label": "博士",
        "value": "博士"
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['courseSelectForm'].validate(valid => {
        if (valid) {
          console.log(this.courseSelectData)
          signUp(this.courseSelectData).then(response=>{
            console.log(response);
            if(response.code===200)
            {
              this.$modal.msgSuccess("报名课程成功");
            }


          })
        }
      });
    },
    resetForm() {
      this.$refs['courseSelectForm'].resetFields()
    },
    handleDateRangeChange()
    {
      this.courseOptions=[];
      let dateList=[];
      dateList[0]=this.courseSelectData.dateRange[0]
      dateList[1]=this.courseSelectData.dateRange[1]
      searchSuitableCourse(dateList).then(response=>{
        console.log(response.data)
        for(let i=0;i<response.data.length;i++)
        {

            this.$set(this.courseOptions,i,{label:response.data[i].time+'：'+response.data[i].courseName,value:response.data[i].courseId});
        }

      })
    }
  }
}

</script>
<style>
.page-title {
  text-align: center;
  margin-bottom: 1px;
  font-size: 40px;
}
.form-container {
  border: 20px solid #ccc;
  padding: 200px;
}
.button-container {
  margin-left: -140px;
  display: flex;
  justify-content: center;
  margin-top: 50px;
}
.label {
  margin-right: 10px;
}
</style>
