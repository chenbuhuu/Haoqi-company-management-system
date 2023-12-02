<template>
  <div>
    <el-row :gutter="15">
      <el-form ref="applyForm" :model="applyData" :rules="rules" size="medium" label-width="100px">
        <el-col :span="10">
          <el-form-item label="公司名称" prop="applicant">
            <el-input v-model="applyData.applicant" placeholder="请输入公司名称"  show-word-limit
                      clearable prefix-icon='el-icon-office-building' :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="申请课程名" prop="applicationCourseName">
            <el-input v-model="applyData.applicationCourseName" placeholder="请输入申请课程名" clearable
                      prefix-icon='el-icon-set-up' :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item label="培训内容" prop="applicationContent">
            <el-input v-model="applyData.applicationContent" type="textarea" placeholder="请输入培训内容"
                      :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
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
import { apply} from "@/api/apply/apply";

export default {
  components: {},
  props: [],
  data() {
    return {
      applyData: {
        applicant: '',
        applicationCourseName: undefined,
        applicationContent: undefined,
      },
      rules: {
        applicant: [{
          required: true,
          message: '请输入公司名称',
          trigger: 'blur'
        }],
        applicationCourseName: [{
          required: true,
          message: '请输入申请课程名',
          trigger: 'blur'
        }],
        applicationContent: [{
          required: true,
          message: '请输入培训内容',
          trigger: 'blur'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['applyForm'].validate(valid => {
        if (!valid) return
        apply(this.applyData).then(response=>{
          console.log(response);
          if(response.code===200)
          {
            this.$modal.msgSuccess("申请课程成功，等候审批");
            this.resetForm();
          }
        })
      })
    },
    resetForm() {
      this.$refs['applyForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
