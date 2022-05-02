<template>
    <!--//头部-->
    <Header :user="user"/>
    <!--主体-->
    <div style="display: flex">
        <!--侧边栏-->
        <Aside/>

        <router-view style="flex: 1" @userInfo="refreshUser"/>
    </div>
</template>

<script>
    import Aside from "../components/Aside";
    import Header from "../components/Header";
    import request from "../../utils/request";

    export default {
        name: "Layout",
        components:{
            Aside,
            Header
        },
        data(){
            return{
                user:{}
            }
        },
        created() {
            this.refreshUser();
        },
        methods:{
            refreshUser(){
                let userJson = sessionStorage.getItem("user");
                if(!userJson){
                    return;
                }else {
                    let  userId = JSON.parse(userJson).id
                    request.get("/api/user/"+userId).then(res => {
                        console.log(res.data)
                        this.user = res.data
                    })
                }

            }
        }
    }
</script>

<style scoped>

</style>