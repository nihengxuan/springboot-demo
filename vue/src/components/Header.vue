<template>
  <div style="height: 50px; line-height: 50px;border-bottom:1px solid #ccc; display: flex">
    <div style="width: 200px;margin-left: 50px;font-weight:bold; color: dodgerblue ">后台管理</div>
    <div style="flex: 1">1</div>
    <div style="width: 100px">
       <el-dropdown>
  <span class="el-dropdown-link" >
    {{user.username}}<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item @click="$router.push('/person')">个人信息</el-dropdown-item>
          <el-dropdown-item @click="$router.push('/login')">退出</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>



    </div>

  </div>

</template>

<script>
export default {
  name: "Header",
  props:['user'],
  data(){
    return{
       // username:''
    }
  },
  created() {
    // var userJson=sessionStorage.getItem("user");
    // this.username = JSON.parse(userJson).username;
  }
}
</script>

<style >
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
.el-icon-arrow-down {
  font-size: 12px;
}

</style>