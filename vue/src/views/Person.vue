<template>
    <div>
        <div style="margin-left: 200px; padding-top: 30px ;font-size: 30px;">
            个人信息
        </div>
        <div>
            <el-form ref="form" :model="form" label-width="80px" style="width: 400px;margin: 50px  50px">

                <el-form-item label="用户名">
                    <el-input v-model="form.username"></el-input>
                </el-form-item>
                <el-form-item label="昵称">
                    <el-input v-model="form.nickName"></el-input>
                </el-form-item>
                <el-form-item label="年龄">
                    <el-input v-model="form.age"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-input v-model="form.sex"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input v-model="form.address"></el-input>
                </el-form-item>
                <el-form-item label="密码" >
                    <el-input v-model="form.password" show-password></el-input>
                </el-form-item>
            </el-form>
        </div>
        <div style="margin-left: 160px">
            <el-button style="width: 200px;background-color: #409eff;color: aliceblue" @click="updatetwo">确认修改</el-button>
        </div>
    </div>


</template>

<script>
    import request from "../../utils/request";

    export default {
        name: "Person",
        data() {
            return {
                form: {

                    username: '',
                    nickName: '',
                    age: '',
                    sex: '',
                    address: '',
                    password: ''

                }
            }
        },
        methods: {
            updatetwo() {
                request.put("/api/user", this.form).then(res => {
                    console.log(res)

                    this.$message({
                        type: "success",
                        message: "更新成功"
                    })

                    //this.$router.push('/user')
                    sessionStorage.setItem("user", JSON.stringify(this.form))
                    // 触发Layout更新用户信息
                    //同步更新
                    this.$emit("userInfo")
                })
            }
        },
        created() {
            // var item = sessionStorage.getItem("user");
            // this.form.id = JSON.parse(item).id
            // this.form.username = JSON.parse(item).username
            // this.form.nickName = JSON.parse(item).nickName
            // this.form.age = JSON.parse(item).age
            // this.form.sex = JSON.parse(item).sex
            // this.form.address = JSON.parse(item).address
            // this.form.password = JSON.parse(item).password
            let str = sessionStorage.getItem("user") || "{}"
            this.form = JSON.parse(str)

        }
    }
</script>

<style scoped>

</style>