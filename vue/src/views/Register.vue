<template>
    <div style="width: 100%;height: 100vh;overflow: hidden" >
        <div style="margin: 150px auto;width: 400px;">
            <div style="text-align: center;font-size: 30px;padding-bottom: 30px;color: #409eff">欢迎注册</div>
            <el-form ref="form" :model="form" :rules="rules">
                <el-form-item prop="username">
                    <el-input v-model="form.username"  prefix-icon="el-icon-user-solid" placeholder="用户名"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="form.password" prefix-icon="el-icon-lock" show-password placeholder="密码"></el-input>
                </el-form-item>
                <el-form-item prop="confirm">
                    <el-input v-model="form.confirm" prefix-icon="el-icon-lock" show-password placeholder="确认密码"></el-input>
                </el-form-item>
                <el-form-item prop="nickName">
                    <el-input v-model="form.nickName" prefix-icon="el-icon-user" placeholder="昵称"></el-input>
                </el-form-item>
                <el-form-item prop="age">
                    <el-input v-model="form.age" prefix-icon="el-icon-age" placeholder="年龄"></el-input>
                </el-form-item>
                <el-form-item prop="sex">
                    <el-input v-model="form.sex" prefix-icon="el-icon-sex" placeholder="性别"></el-input>
                </el-form-item>
                <el-form-item prop="address">
                    <el-input v-model="form.address" prefix-icon="el-icon-address" placeholder="地址"></el-input>
                </el-form-item>
            </el-form>
            <el-button style="width: 100%;background-color: #409eff;color: #f0f8ff" @click="register">注册</el-button>
        </div>
    </div>
</template>

<script>
    import request from "../../utils/request";

    export default {
        name: "Register",
        data() {
            return {
                form: {
                    username: '',
                    password: '',
                    confirm: '',
                    nickName:'',
                    age:'',
                    sex:'',
                    address:'',
                },
                rules:{
                    username:[
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        {
                            min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur',
                        },
                    ],
                    password:[
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        {
                            min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur',
                        },
                    ],
                    confirm:[
                        { required: true, message: '请确认密码', trigger: 'blur' },
                        {
                            min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur',
                        },
                    ],
                    nickName:[
                        { required: true, message: '请输入昵称', trigger: 'blur' },
                    ],
                    sex:[
                        { required: true, message: '请输入性别', trigger: 'blur' },
                    ],
                    age:[
                        { required: true, message: '请输入年龄', trigger: 'blur' },
                    ],
                    address:[
                        { required: true, message: '请输入地址', trigger: 'blur' },
                    ],



                }

            }
        },
        methods: {
            register(){

                if(this.form.password != this.form.confirm){
                    this.$message({
                        type:"error",
                        message:"两次输入密码不同"
                    })
                    return;
                }
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        request.post("api/user/register",this.form).then(res => {
                            console.log(res)
                            if (res.code === '200') {
                                this.$message({
                                    type: "success",
                                    message: "注册成功"
                                })
                                this.$router.push("/login")
                            } else {
                                this.$message({
                                    type: "error",
                                    message: "该用户已存在"
                                })
                            }

                        })
                    }
                })

                }


        }
    }




</script>

<style scoped>

</style>