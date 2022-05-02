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
      <el-table-column prop="id" label="ID" sortable > </el-table-column>
      <el-table-column prop="username" label="用户名" > </el-table-column>
      <el-table-column prop="nickName" label="昵称" > </el-table-column>
      <el-table-column prop="age" label="年龄" > </el-table-column>
      <el-table-column prop="sex" label="性别" > </el-table-column>
      <el-table-column prop="address" label="地址"> </el-table-column>
      <el-table-column prop="role" label="角色">
        <template #default="scope">
          <span v-if="scope.row.role === 1">管理员</span>
          <span v-if="scope.row.role === 2">普通用户</span>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" min-width="100" >
        <template #default="scope">
          <el-button @click="showBooks(scope.row.booklist)" plain type="success" size="mini">查看图书列表</el-button>
          <el-button @click="handleEdit(scope.row)" plain type="primary" size="mini">编辑</el-button>
          <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button  type="danger"  size="mini" >删除</el-button>
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

    <el-dialog  title="对应关系" v-model="bookDia" width="30%">
      <el-table :data="booklist" label-width="80px" stripe border>
        <el-table-column prop="id" label="ID" ></el-table-column>
        <el-table-column prop="name" label="书名"></el-table-column>
        <el-table-column prop="price" label="价格" ></el-table-column>
      </el-table>
    </el-dialog>

    <el-dialog  title="添加新用户" v-model="dialogVisible" width="30%">
      <el-form :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="form.username" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="form.nickName" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="form.sex" label="男">男</el-radio>
          <el-radio v-model="form.sex" label="女">女</el-radio>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="form.address" style="width: 80%"></el-input>
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
  name: '',

  components: {

  },
  data(){
    return {
      bookDia:false,
      form:{},
      dialogVisible:false,
      search:'',
      currentPage:1,
      pageSize:10,
      total:0,
      tableData: [],
      booklist:[],
    }

    },
  created(){
    this.load()
  },

  methods:{

     load(){
       request.get("/api/user",{
         params:{
           username:this.search,
           pageNum:this.currentPage,
           pageSize:this.pageSize,
         }
      }).then( res => {
         this.total = res.pagedata.total

      })
       request.get("/api/user/list").then(res => {
         console.log(res.data)
         this.tableData = res.data

       })
    },
    showBooks(books){
      console.log(books)
        this.booklist = books;
        this.bookDia = true
    },
    selsearch(){
      this.load(this.search,this.currentPage, this.pageSize);
    },
    save(){
       if(this.form.id){//更新
         request.put("/api/user",this.form).then(res =>{
           console.log(res)
           this.$message({
             type:"success",
             message:"更新成功"
           })


         });

         this.dialogVisible = false
       }else {//新增
         request.post("/api/user",this.form).then(res =>{
           console.log(res)
           this.$message({
             type:"success",
             message:"新增成功"
           })
         });

         this.dialogVisible = false
       }
      this.load()
    },
    add() {
      this.dialogVisible=true
      this.form={}
      this.load()
    },
    handleEdit(row) {
       console.log(row)
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true

    },
    handleDelete(id){
      console.log(id)
      request.delete("/api/user/"+id).then( res => {
        console.log(id)
        this.$message({
          type:"success",
          message:"删除成功"
        })
      })
      this.load()
    },
    handleSizeChange(pageSize){//当前页面多少

       this.pageSize = pageSize;
       this.load()
    },
    handleCurrentChange(pageNum){//当前页码
       this.currentPage = pageNum;
      this.load()
    },

  }
}
</script>
