<template>
    <div style="width: 100%;height: 100vh;overflow: hidden" >
        <div style="margin: 150px auto;width: 400px;">
        <div style="text-align: center;font-size: 30px;padding-bottom: 30px;color: #409eff">欢迎登陆</div>
            <el-form ref="form" :model="form" >
                <el-form-item >
                    <el-input v-model="form.username"  prefix-icon="el-icon-user-solid"></el-input>
                </el-form-item>
                <el-form-item >
                    <el-input v-model="form.password" prefix-icon="el-icon-lock" show-password></el-input>
                </el-form-item>
            </el-form>
            <div style="margin-left: 60px">
                <el-button style="width: 40%;background-color: #409eff;color: aliceblue" @click="login">登录</el-button>
                <el-button style="width: 40%;background-color: #409eff;color: aliceblue" @click="goregister">注册</el-button>
            </div>

        </div>
    </div>
</template>

<script>
    import request from "../../utils/request";
    import {activeRouter} from "../../utils/permission";

    export default {
        name: "Login",
        data(){
            return{
                form:{
                    username:'',
                    password:'',
                }
            }
        },
        methods:{
            login(){
                request.get("api/user/login", {
                    params:{
                        username:this.form.username,
                        password:this.form.password
                    }

                }).then(res =>{
                    console.log(res.code)
                    if(res.code==='200'){
                        this.$message({
                            type:"success",
                            message:"登录成功"
                        })
                        sessionStorage.setItem("user",JSON.stringify(res.data))

                        const permissions = res.data.permission
                        console.log(res.data.permission)
                        //初始化路由信息
                        activeRouter()
                        this.$router.push("/book")
                    }else {
                        this.$message({
                            type:"error",
                            message:"用户名或密码错误"
                        })
                    }

                })
            },
            goregister(){
                this.$router.push("/register")
            }
        }
    }
</script>

<style scoped>

</style>