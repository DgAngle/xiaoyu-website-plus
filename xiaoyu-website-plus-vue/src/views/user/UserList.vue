<template>
  <div style="padding: 10px">

    <div style="margin: 10px 0;">
      <el-button type="primary" icon="el-icon-plus">添加</el-button>
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
      <!--      <el-input v-model="query.name" placeholder="请输入名称"/>-->
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
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="date" label="日期" width="180" sortable></el-table-column>
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>

</template>

<script>

export default {
  name: 'UserList',
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
    }
  },
  methods: {
    handleEdit(index, row) {
    },
    handleDelete(index, row) {
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
</style>
