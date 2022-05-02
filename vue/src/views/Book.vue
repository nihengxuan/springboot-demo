<template>
    <div class="home">
        <div style="padding: 10px; width: 100%" >
            <el-button type="primary" size="small" @click="add">新增</el-button>
            <el-button type="primary" size="small">导入</el-button>
            <el-button type="primary" size="small">导出</el-button>
        </div>
        <div style="display: flex;height: 40px">
            <el-input v-model="search" style="width: 250px" placeholder="请输入用户名关键字" size="small"></el-input>
            <el-button style="margin-left: 20px;width: 70px;height: 20px" type="primary" size="small" @click="selsearch" clearable>查讯</el-button>
        </div>
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="id" label="ID" sortable> </el-table-column>
            <el-table-column prop="name" label="书名" sortable> </el-table-column>
            <el-table-column prop="price" label="价格" sortable> </el-table-column>
            <el-table-column prop="author" label="作者" sortable> </el-table-column>
            <el-table-column prop="createTime" label="出版时间" sortable> </el-table-column>
            <el-table-column  label="封面" >
                <template #default="scope">
                    <el-image
                            style="width: 100px; height: 100px"
                            :src="scope.row.cover"
                            :preview-src-list="[scope.row.cover]">
                    </el-image>
                </template>

            </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
                <template #default="scope">
                    <el-button @click="handleEdit(scope.row)" type="text" size="small">编辑</el-button>
                    <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row.id)">
                        <template #reference>
                            <el-button  type="text" size="small" >删除</el-button>
                        </template>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage"
                :page-sizes="[5, 10, 20, 50]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>


        <el-dialog  title="添加新书籍" v-model="dialogVisible" width="30%">
            <el-form :model="form" label-width="80px">
                <el-form-item label="书名">
                    <el-input v-model="form.name" style="width: 80%"></el-input>
                </el-form-item>
                <el-form-item label="价格">
                    <el-input v-model="form.price" style="width: 80%"></el-input>
                </el-form-item>
                <el-form-item label="作者 ">
                    <el-input v-model="form.author" style="width: 80%"></el-input>
                </el-form-item>

                <el-form-item label="创作时间">
                    <el-date-picker v-model="form.createTime" value-format="YYYY-MM-DD" type="data" style="width: 80%"></el-date-picker>
                </el-form-item>
                <el-form-item label="上传图片">
                    <el-upload ref="upload" action="http://localhost:8802/files/upload/" :on-success="fileUploadSuccess" show-file-list>
                        <el-button size="small" type="primary">点击上传</el-button>
                    </el-upload>
                </el-form-item>

            </el-form>
            <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button>
        </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
    import request from "../../utils/request";

    export default {
        name: "Book",
        data(){
            return{
                form:{},
                dialogVisible:false,
                search:'',
                currentPage:1,
                pageSize:10,
                total:0,
                tableData: []
            }
        },
        created() {
            this.load()
        },
        methods:{
            fileUploadSuccess(res){
                console.log(res)
                this.form.cover = res.data
            },
            load(){
                request.get("/api/book/list",{
                    params:{
                        pageNum:this.currentPage,
                        pageSize:this.pageSize,
                        name:this.search,
                    }
                }).then(res => {
                    console.log(res.data)
                    this.tableData = res.data.list
                    this.total = res.data.total
                })
            },
            selsearch(){
                this.load(this.search,this.currentPage,this.pageSize)
            },
            save(){
                if(this.form.id){
                    request.put("/api/book/update",this.form).then(res => {
                        this.$message({
                            type: "success",
                            message: "更新成功"
                        })

                    })
                    this.load()
                    this.dialogVisible = false

                }else {
                    request.post("/api/book/insert",this.form).then(res => {//添加
                        console.log(res.data)
                        this.$message({
                            type: "success",
                            message: "添加成功"
                        })
                        this.load()

                    })
                    this.dialogVisible = false
                }

            },
            add(){
                this.dialogVisible = true
                this.form = {}
                this.$refs['upload'].clearFiles()
            },
            handleEdit(row){
                this.form = JSON.parse(JSON.stringify(row))
                this.dialogVisible = true
                this.$refs['upload'].clearFiles()
            },
            handleDelete(id){
                console.log(id)
                request.delete("/api/book/"+id).then(res => {
                    console.log(res)
                    this.$message({
                        type: "success",
                        message: "删除成功"
                    })
                    this.load()
                })

            },
            handleSizeChange(pageSize){
                this.pageSize = pageSize
                this.load()
            },
            handleCurrentChange(pageNum){
                this.currentPage = pageNum
                this.load()
            },




        }
    }
</script>

<style scoped>

</style>