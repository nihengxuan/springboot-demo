<template>
  <div>

      <el-menu
          style="width: 200px; min-height: 92vh;"
          :default-active="path"
          :default-openeds="[1]"
          router
          class="el-menu-vertical-demo">
        <el-menu-item :index="m.path" v-for="m in user.permission" :key="m.id">
          {{m.comment}}
        </el-menu-item>
      </el-menu>

  </div>
</template>

<script>
import request from "../../utils/request";

export default {
  name: "Aside",
  data(){
    return{
        path:this.$route.path,
        user:{}
    }
  },
created() {
  let userStr = sessionStorage.getItem("user");
  this.user=JSON.parse(userStr);

  request.get("/api/user/"+this.user.id).then(res => {
     console.log(res.data.role)
    if(res.data.code === "0"){
      this.user=res.data
    }

  })
}

}
</script>

<style scoped>

</style>