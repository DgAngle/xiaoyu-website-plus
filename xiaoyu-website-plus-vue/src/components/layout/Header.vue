<template>
  <!-- 头部菜单 -->
  <div class="header">
    <div class="header-logo">小羽网站</div>
    <div class="header-opt"></div>
    <div class="header-user">
      <el-dropdown trigger="click" style=" cursor: pointer;">
        <span class="el-dropdown-link">
          admin<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item icon="el-icon-user-solid">个人信息</el-dropdown-item>
            <el-dropdown-item icon="el-icon-top-right">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>

  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>
.header {
  height: 50px;
  line-height: 50px;
  border-bottom: 1px solid #ccc;
  display: flex;
}

.header-logo {
  width: 200px;
  /*padding-left: 30px;*/
  font-weight: bold;
  text-align: center;
}

.header-opt {
  flex: 1;
}

.header-user {
  width: 100px;
  text-align: center;
}

</style>