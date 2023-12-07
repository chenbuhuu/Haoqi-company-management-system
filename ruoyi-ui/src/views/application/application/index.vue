<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="申请课程名" prop="applicationCourseName">
        <el-input
          v-model="queryParams.applicationCourseName"
          placeholder="请输入申请课程名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请公司" prop="applicant">
        <el-input
          v-model="queryParams.applicant"
          placeholder="请输入申请公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请结果" prop="result">
        <el-select v-model="queryParams.result" placeholder="请选择申请结果" clearable>
          <el-option
            v-for="dict in dict.type.application_check_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="执行人" prop="executor">
        <el-input
          v-model="queryParams.executor"
          placeholder="请输入执行人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['application:application:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->

<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['application:application:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['application:application:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="applicationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="applicationId" />
      <el-table-column label="申请课程名" align="center" prop="applicationCourseName" />
      <el-table-column label="申请课程内容" align="center" prop="applicationContent" />
      <el-table-column label="申请公司" align="center" prop="applicant" />
      <el-table-column label="申请结果" align="center" prop="result">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.application_check_status" :value="scope.row.result"/>
        </template>
      </el-table-column>
      <el-table-column label="执行人" align="center" prop="executor" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <div style="display: flex; align-items: center;">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['application:application:edit']"
          >分配执行人</el-button>
          </div>

            <div style="display: flex; align-items: center;">
          <el-button
            v-if="scope.row.result == 0"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="commit(scope.row)"
            v-hasPermi="['application:application:edit']"
          >审核</el-button>
            </div>

              <div style="display: flex; align-items: center;">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['application:application:remove']"
          >删除</el-button>
              </div>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改培训申请管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="申请课程名" prop="applicationCourseName">-->
<!--          <el-input v-model="form.applicationCourseName" placeholder="请输入申请课程名" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="申请课程内容" prop="applicationContent">-->
<!--          <el-input v-model="form.applicationContent" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="申请公司" prop="applicant">-->
<!--          <el-input v-model="form.applicant" placeholder="请输入申请公司" />-->
<!--        </el-form-item>-->
        <el-form-item label="执行人" prop="executor">
          <el-input v-model="form.executor" placeholder="请输入执行人" />
        </el-form-item>
<!--        <el-form-item label="备注" prop="remark">-->
<!--          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listApplication, getApplication, delApplication, addApplication, updateApplication ,commit} from "@/api/application/application";

export default {
  name: "Application",
  dicts: ['application_check_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 培训申请管理表格数据
      applicationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        applicationCourseName: null,
        applicationContent: null,
        applicant: null,
        result: null,
        executor: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        applicationCourseName: [
          { required: true, message: "申请课程名不能为空", trigger: "blur" }
        ],
        applicationContent: [
          { required: true, message: "申请课程内容不能为空", trigger: "blur" }
        ],
        applicant: [
          { required: true, message: "申请公司不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询培训申请管理列表 */
    getList() {
      this.loading = true;
      listApplication(this.queryParams).then(response => {
        this.applicationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        applicationId: null,
        applicationCourseName: null,
        applicationContent: null,
        applicant: null,
        result: null,
        executor: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.applicationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加培训申请管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const applicationId = row.applicationId
      getApplication(applicationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "分配执行人";
      });
    },
    /** 审核按钮操作 */
    commit(row) {
      this.reset();
      const applicationId = row.applicationId
      getApplication(applicationId).then(response => {
        this.form = response.data;
        commit(this.form).then(response=>{
          this.$modal.msgSuccess("审核成功");
          this.reset();
          this.getList();
        })
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.applicationId != null) {
            updateApplication(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addApplication(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const applicationIds = row.applicationId || this.ids;
      this.$modal.confirm('是否确认删除培训申请管理编号为"' + applicationIds + '"的数据项？').then(function() {
        return delApplication(applicationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('application/application/export', {
        ...this.queryParams
      }, `application_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
