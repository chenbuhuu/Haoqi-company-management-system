<template>
  <div>
    <el-row :gutter="15">
      <el-form ref="courseSelectForm" :model="courseSelectData" :rules="rules" size="medium"
               label-width="100px">
        <el-col :span="10">
          <el-form-item label="身份证号" prop="IdNum">
            <el-input v-model="courseSelectData.IdNum" placeholder="请输入您的身份证号" show-word-limit clearable
                      prefix-icon='el-icon-postcard' :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="日期范围" prop="dateRange">
            <el-date-picker type="daterange" v-model="courseSelectData.dateRange" format="yyyy-MM-dd"
                            value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期"
                            end-placeholder="结束日期" range-separator="至" clearable @change="handleDateRangeChange"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="课程选择" prop="course">
            <el-select v-model="courseSelectData.course" placeholder="请选择课程" filterable clearable
                       :style="{width: '100%'}">
              <el-option v-for="(item, index) in courseOptions" :key="index" :label="item.label"
                         :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
  </div>
</template>

<script>
import { searchSuitableCourse} from "@/api/signUp/signUp";

export default {
  components: {},
  props: [],
  data() {
    return {
      courseSelectData: {
        IdNum: undefined,
        dateRange: ['2023-11-11','2023-11-13'],
        course: undefined,
      },
      rules: {
        IdNum: [{
          required: true,
          message: '请输入您的身份证号',
          trigger: 'blur'
        }],
        dateRange: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
        course: [{
          required: true,
          message: '请选择课程',
          trigger: 'change'
        }],
      },
      courseOptions: [],
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
          this.$modal.msgSuccess("提交成功");
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
        for(let i=0;i<response.data.length;i++)
        {
            this.$set(this.courseOptions,i,{label:response.data[i].courseName,value:i});
        }

      })
    }
  }
}

</script>
<style></style>
