import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: ()=> import('../layout/Layout'),
    redirect:"/login",
    children:[
      //   {
      //     path: 'user',
      //     name: 'User',
      //     component: () => import("../views/User")
      // },
      // {
      //   path: 'person',
      //   name: 'Person',
      //   component: () => import("../views/Person")
      // },
      // {
      //   path: 'book',
      //   name: 'Book',
      //   component: () => import("../views/Book")
      // },
      // {
      //   path: 'news',
      //   name: 'News',
      //   component: () => import("../views/News")
      // },
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: ()=> import('../views/Login')
  },
  {
    path: '/register',
    name: 'register',
    component: ()=> import('../views/Register')
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})


//刷新页面的时候重置路由
activeRouter()
function activeRouter() {
  const userStr = sessionStorage.getItem("user")
  if (userStr) {
    const user = JSON.parse(userStr);
    let root = {
      path: '/',
      name: 'Layout',
      component: () => import('../layout/Layout'),
      redirect: "/login",
      children: []
    }
    user.permission.forEach(p => {
      let obj = {
        path: p.path,
        name: p.name,
        component: () => import("../views/" + p.name)

      };
      root.children.push(obj)


    })
    //动态添加路由信息，重复的路由会被覆盖
    if (router){
      router.addRoute(root)
    }

  }
}

router.beforeEach((to, from, next) => {
  if(to.path === '/login'){
    next()
    return;
  }
  let user = sessionStorage.getItem("user") ? JSON.parse(sessionStorage.getItem("user")):{}
  if (!user.permission || !user.permission.length){
    next('/login')
  }else if (!user.permission.find(p => p.path === to.path)){
    next('/login')
  }else {
    next()
  }
})

export default router