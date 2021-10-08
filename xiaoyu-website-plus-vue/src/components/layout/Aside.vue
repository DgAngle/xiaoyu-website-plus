<template>
  <!--侧边栏-->
  <div>
    <!--    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">-->
    <!--      <el-radio-button :label="false">expand</el-radio-button>-->
    <!--      <el-radio-button :label="true">collapse</el-radio-button>-->
    <!--    </el-radio-group>-->
    <el-menu
        default-active="1"
        class="aside-menu"
        :collapse="isCollapse">

      <el-menu-item index="1">
        <i class="el-icon-menu"></i>
        <template #title>主页</template>
      </el-menu-item>
      <el-sub-menu index="2-4">
        <template #title>
          <i class="el-icon-setting"></i>
          <span>系统配置</span>
        </template>
        <el-menu-item index="2-4-1">用户管理</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="3">
        <template #title>
          <i class="el-icon-location"></i>
          <span>笔记管理</span>
        </template>
        <el-menu-item index="3-1">笔记分类</el-menu-item>
        <el-menu-item index="3-2">笔记列表</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script>

export default {
  name: "Aside",
  data() {
    return {
      isCollapse: false,
    }
  }
}
</script>

<style scoped>

.aside-menu:not(.el-menu--collapse) {
  width: 200px;
  min-height: calc(100vh - 50px);
}
</style>