<template>
  <div id="nav">
    <Header/>
    <div style="display: flex">
      <Aside/>
      <router-view style="flex: 1"/>
    </div>
  </div>

</template>

<style>
</style>

<script>
import Header from "@/components/layout/Header";
import Aside from "@/components/layout/Aside";

export default {
  name: 'Layout',
  components: {
    Aside,
    Header
  }

}
</script>
