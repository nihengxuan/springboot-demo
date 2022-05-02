import router from "../src/router";
//设置动态路由
//permissions是一个资源数组
export function activeRouter() {
    const userStr = sessionStorage.getItem("user")
    if (userStr) {
        const user = JSON.parse(userStr);
        let root = {
            path: '/',
            name: 'Layout',
            component: () => import('../src/layout/Layout'),
            redirect: "/login",
            children: []
        }
        user.permission.forEach(p => {
            let obj = {
                path: p.path,
                name: p.name,
                component: () => import("../src/views/" + p.name)

            };
            root.children.push(obj)


        })
        //动态添加路由信息，重复的路由会被覆盖
        if (router){
            router.addRoute(root)
        }

    }
}