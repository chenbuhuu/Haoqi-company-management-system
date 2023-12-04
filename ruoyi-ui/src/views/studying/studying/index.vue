<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生身份证" prop="csStudentId"style="white-space: nowrap;">
        <el-input
          v-model="queryParams.csStudentId"
          placeholder="请输入学生身份证"
          clearable
          style="width: 230px;margin-left: 20px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学员姓名" prop="csStudentId">
        <el-input
          v-model="queryParams['hqStudent.studentName']"
          placeholder="请输入学员姓名"
          clearable
          style="width: 250px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程编号" prop="csCourseId">
        <el-input
          v-model="queryParams.csCourseId"
          placeholder="请输入课程编号"
          clearable
          style="width: 250px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程名" prop="csCourseId">
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
      <el-form-item label="缴费状态" prop="payment">
        <el-select v-model="queryParams.payment" placeholder="请选择缴费状态" style="width: 250px" clearable>
          <el-option
            v-for="dict in dict.type.payment_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="签到状态" prop="sign">
        <el-select v-model="queryParams.sign" placeholder="请选择签到状态" style="width: 250px" clearable>
          <el-option
            v-for="dict in dict.type.sign_in_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="报名状态" prop="registStatus">
        <el-select v-model="queryParams.registStatus" placeholder="请选择报名状态" style="width: 250px" clearable>
          <el-option
            v-for="dict in dict.type.sign_up_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="课程评价" prop="evaluate">
        <el-input
          v-model="queryParams.evaluate"
          placeholder="请输入课程评价"
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
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['studying:studying:add']"-->
<!--        >新增</el-button>-->
      </el-col>
      <el-col :span="1.5">
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['studying:studying:edit']"-->
<!--        >审批</el-button>-->
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['studying:studying:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['studying:studying:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studyingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="学生身份证" align="center" prop="hqStudent.studentId" />
      <el-table-column label="学员姓名" align="center" prop="hqStudent.studentName" />
      <el-table-column label="课程编号" align="center" prop="hqCourse.courseId" />
      <el-table-column label="课程名" align="center" prop="hqCourse.courseName" />
      <el-table-column label="课程地点" align="center" prop="hqCourse.place" />
      <el-table-column label="课程时间" align="center" prop="hqCourse.time" />
      <el-table-column label="缴费状态" align="center" prop="payment">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.payment_status" :value="scope.row.payment"/>
        </template>
      </el-table-column>
      <el-table-column label="签到状态" align="center" prop="sign">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sign_in_status" :value="scope.row.sign"/>
        </template>
      </el-table-column>
      <el-table-column label="报名状态" align="center" prop="registStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sign_up_status" :value="scope.row.registStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="课程评价" align="center" prop="evaluate" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <div style="display: flex; align-items: center;">
            <el-button
              v-if="scope.row.registStatus == 0"
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['studying:studying:edit']"
            >审批</el-button></div>
          <div style="display: flex; align-items: center;">
            <el-button
              v-if="scope.row.payment == 0"
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="pay(scope.row)"
            >缴费</el-button>
          </div>
          <div style="display: flex; align-items: center;">
            <el-button
              v-if="scope.row.sign == 0"
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="signIn(scope.row)"
            >签到</el-button>
          </div>
          <div style="display: flex; align-items: center;">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['studying:studying:remove']"
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

    <!-- 添加或修改学员上课信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生身份证" prop="csStudentId">
          <el-input v-model="form.csStudentId" placeholder="请输入学生身份证" />
        </el-form-item>
        <el-form-item label="课程编号" prop="csCourseId">
          <el-input v-model="form.csCourseId" placeholder="请输入课程编号" />
        </el-form-item>
        <el-form-item label="缴费状态" prop="payment">
          <el-radio-group v-model="form.payment">
            <el-radio
              v-for="dict in dict.type.payment_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="签到状态" prop="sign">
          <el-radio-group v-model="form.sign">
            <el-radio
              v-for="dict in dict.type.sign_in_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="报名状态" prop="registStatus">
          <el-radio-group v-model="form.registStatus">
            <el-radio
              v-for="dict in dict.type.sign_up_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="课程评价" prop="evaluate">
          <el-input v-model="form.evaluate" placeholder="请输入课程评价" />
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
import { listStudying, getStudying, delStudying, addStudying, updateStudying ,pay,signIn} from "@/api/studying/studying";

export default {
  name: "Studying",
  dicts: ['sign_up_status', 'sign_in_status', 'payment_status'],
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
      // 学员上课信息管理表格数据
      studyingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        csStudentId: null,
        csCourseId: null,
        payment: null,
        sign: null,
        registStatus: null,
        evaluate: null,
        'hqStudent.studentName':null,
        'hqCourse.courseName':null,
        'hqCourse.time':null,
        'hqCourse.place':null

      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        csStudentId: [
          { required: true, message: "学生身份证不能为空", trigger: "blur" }
        ],
        csCourseId: [
          { required: true, message: "课程编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学员上课信息管理列表 */
    getList() {
      this.loading = true;
      listStudying(this.queryParams).then(response => {
        this.studyingList = response.rows;
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
        csStudentId: null,
        csCourseId: null,
        payment: null,
        sign: null,
        registStatus: null,
        evaluate: null,
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
      this.title = "添加学员上课信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      console.log(row)
      this.reset();
      const id = row.id
      getStudying(id).then(response => {
        this.form = response.data;
        updateStudying(this.form).then(response => {
          this.$modal.msgSuccess("审批成功");
          this.reset();
          this.getList();
        });
      });
    },
    /**缴费按钮*/
    pay(row){
      console.log(row)
      this.reset();
      const id = row.id
      getStudying(id).then(response => {
        this.form = response.data;
        pay(this.form).then(response => {
          this.$modal.msgSuccess("缴费成功");
          this.reset();
          this.getList();
        });
      });
    },
    /**缴费按钮*/
    signIn(row){
      console.log(row)
      this.reset();
      const id = row.id
      getStudying(id).then(response => {
        this.form = response.data;
        signIn(this.form).then(response => {
          this.$modal.msgSuccess("签到成功");
          this.reset();
          this.getList();
        });
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStudying(this.form).then(response => {
              this.$modal.msgSuccess("审批成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStudying(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除学员上课信息管理编号为"' + ids + '"的数据项？').then(function() {
        return delStudying(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('studying/studying/export', {
        ...this.queryParams
      }, `studying_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
