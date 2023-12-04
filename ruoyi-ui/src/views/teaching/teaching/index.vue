<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="老师编号" prop="tiTeacherId">
        <el-input
          v-model="queryParams.tiTeacherId"
          placeholder="请输入老师编号"
          clearable
          style="width: 250px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="老师姓名" prop="tiTeacherId">
        <el-input
          v-model="queryParams['hqTeacher.teacherName']"
          placeholder="请输入老师姓名"
          clearable
          style="width: 250px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程编号" prop="tiCourseId">
        <el-input
          v-model="queryParams.tiCourseId"
          placeholder="请输入课程编号"
          clearable
          style="width: 250px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程名" prop="tiCourseId">
        <el-input
          v-model="queryParams['hqCourse.courseName']"
          placeholder="请输入课程名"
          clearable
          style="width: 250px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
        <el-form-item label="课程地点" prop="place">
          <el-input
            v-model="queryParams['hqCourse.place']"
            placeholder="请输入课程地点"
            clearable
            style="width: 250px"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="课程时间" prop="time">
          <el-input
            v-model="queryParams['hqCourse.time']"
            placeholder="请输入课程时间"
            clearable
            style="width: 250px"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
      <el-form-item style="display: flex; justify-content: flex-end;">
        <el-button type="primary" icon="el-icon-search" size="mini"  @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini"  @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['teaching:teaching:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['teaching:teaching:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['teaching:teaching:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['teaching:teaching:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teachingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="老师编号" align="center" prop="hqTeacher.teacherId" />
      <el-table-column label="老师姓名" align="center" prop="hqTeacher.teacherName" />
      <el-table-column label="课程编号" align="center" prop="hqCourse.courseId" />
      <el-table-column label="课程名" align="center" prop="hqCourse.courseName" />
      <el-table-column label="课程地点" align="center" prop="hqCourse.place" />
      <el-table-column label="课程时间" align="center" prop="hqCourse.time" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['teaching:teaching:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['teaching:teaching:remove']"
          >删除</el-button>
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

    <!-- 添加或修改讲师代课信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程编号" prop="tiCourseId">
          <el-input v-model="form.tiCourseId" placeholder="请输入课程编号" />
        </el-form-item>
        <el-form-item label="老师编号" prop="tiTeacherId">
          <el-input v-model="form.tiTeacherId" placeholder="请输入老师编号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTeaching, getTeaching, delTeaching, addTeaching, updateTeaching } from "@/api/teaching/teaching";

export default {
  name: "Teaching",
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
      // 讲师代课信息管理表格数据
      teachingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tiCourseId: null,
        tiTeacherId: null,
        'hqTeacher.teacherName':null,
        'hqCourse.courseName':null,
        'hqCourse.time':null,
        'hqCourse.place':null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        tiCourseId: [
          { required: true, message: "课程编号不能为空", trigger: "blur" }
        ],
        tiTeacherId: [
          { required: true, message: "老师编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询讲师代课信息管理列表 */
    getList() {
      this.loading = true;
      listTeaching(this.queryParams).then(response => {
        this.teachingList = response.rows;
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
        id: null,
        tiCourseId: null,
        tiTeacherId: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加讲师代课信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTeaching(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改讲师代课信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTeaching(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeaching(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除讲师代课信息管理编号为"' + ids + '"的数据项？').then(function() {
        return delTeaching(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('teaching/teaching/export', {
        ...this.queryParams
      }, `teaching_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
