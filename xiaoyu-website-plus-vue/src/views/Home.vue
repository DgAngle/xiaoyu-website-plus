<template>
  <div style="padding: 10px">

    <div style="margin: 10px 0;">
      <el-button type="primary" icon="el-icon-plus" @click="openAddUser">添加</el-button>
    </div>

    <div class="form-query">
      <el-form :inline="true" :model="query" class="demo-form-inline">
        <el-form-item label="日期">
          <el-input v-model="query.name" placeholder="请输入日期"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-select v-model="query.catName" placeholder="请输入姓名">
            <el-option label="Zone one" value="shanghai"></el-option>
            <el-option label="Zone two" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" :loading="loading">查询</el-button>
        </el-form-item>
      </el-form>
      <!-- <el-input v-model="query.name" placeholder="请输入名称"/> -->
    </div>

    <div style="margin: 10px 0;">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 15, 20, 30]"
          :page-size="pageCount"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalCount">
      </el-pagination>
    </div>

    <!-- 设置表头样式 -> :header-cell-style="{background:'#0e0e0e', color: '#fff'}"  -->
    <!-- 设置表行样式 -> :row-class-name="tableRowClassName"  -->
    <!-- scope -> scope.$index, scope.row -->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="date" label="日期" width="180" sortable></el-table-column>
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="mini" @click="openUserEdit(scope.row)">编辑</el-button>

          <el-popconfirm
              confirmButtonText="确定"
              cancelButtonText="取消"
              icon="el-icon-info"
              iconColor="red"
              title="确认删除该用户吗？"
              @confirm="userDel(scope.row)"
              @cancel="">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--  添加用户  -->
    <el-dialog v-model="dialogFormVisible" title="添加用户" class="add-form" width="40%">
      <el-form :model="userForm" :rules="userRules">
        <el-form-item label="昵称" :label-width="formLabelWidth">
          <el-input v-model="userForm.nickname" autocomplete="off" class="add-form-input"></el-input>
        </el-form-item>
        <el-form-item label="用户名" :label-width="formLabelWidth" prop="username">
          <el-input v-model="userForm.username" autocomplete="off" class="add-form-input"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
          <el-input v-model="userForm.password" :type="passwordType" autocomplete="off"
                    class="add-form-input"></el-input>
          <i slot="suffix" class="el-icon-view" @click="showPassword"></i>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-radio-group v-model="userForm.sex">
            <el-radio :label="1">男</el-radio>
            <el-radio :label="2">女</el-radio>
            <el-radio :label="3">未知</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="角色" :label-width="formLabelWidth">
          <el-select v-model="userForm.roleId" placeholder="">
            <el-option label="超级管理员" :value="1"></el-option>
            <el-option label="管理员" :value="2"></el-option>
            <el-option label="普通用户" :value="3"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="addUser()">确认</el-button
        >
      </span>
      </template>
    </el-dialog>

  </div>

</template>

<script>
// @ is an alias to /src
import request from "@/utils/request";

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      tableData: [
        {date: '2016-05-02', name: '王小虎', address: '上海市普陀区金沙江路 1518 弄',},
        {date: '2016-05-04', name: '王小虎', address: '上海市普陀区金沙江路 1517 弄',},
        {date: '2016-05-01', name: '王小虎', address: '上海市普陀区金沙江路 1519 弄',},
        {date: '2016-05-03', name: '王小虎', address: '上海市普陀区金沙江路 1516 弄',},
      ],
      query: {},
      loading: false,
      currentPage: 1,
      pageCount: 20,
      totalCount: 60,
      dialogFormVisible: false,
      userForm: {},
      passwordType: 'password',
      formLabelWidth: '120px',
      userRules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur',},
          {min: 3, max: 20, message: '用户名最低3位, 最高20位', trigger: 'blur',},
        ],
        password: [
          {required: true, message: '请输入用户密码', trigger: 'blur',},
          {min: 3, max: 20, message: '用户名最低3位, 最高20位', trigger: 'blur',},
        ],
      },
      userList: [],
    }
  },
  methods: {

    showPassword() {
      this.passwordType = this.passwordType == 'password' ? 'text' : 'password';
    },
    openAddUser() {
      this.dialogFormVisible = true;
      this.userForm = {
        sex: 1,
        roleId: 3,
      };
    },
    addUser() {
      request.post("user/");
    },
    openUserEdit(row) {
      console.log(row)
    },
    userEdit() {
    },
    userDel(row) {
      console.log(row)
    },
    handleSizeChange() {
    },
    handleCurrentChange() {
    },
    tableRowClassName({row, rowIndex}) {
      if ((rowIndex + 1) % 2 === 0) {
        return "warning-row"; //类名
      } else {
        return "success-row"; //类名
      }
    }
  }
}
</script>

<style scoped>
.form-query {
  margin-top: 20px;
}

.add-form .el-input {
  width: 80%;
}

.add-form-input {
  width: 80%;
}
</style>
