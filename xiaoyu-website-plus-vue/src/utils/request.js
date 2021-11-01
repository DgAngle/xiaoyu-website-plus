import axios from 'axios'

const request = axios.create({timeout: 5000})

// request拦截器
// 针对请求发送前进行处理, 比如添加 Token 或者对参数统一加密等等
request.interceptors.request.use(config => {
    // 设置请求头
    config.headers['content-type'] = 'application/json;charset=utf-8'
    // config.headers['token'] = user.token // token封装

    return config
}, error => {
    return Promise.reject(error)
})


// response拦截器
// 统一处理响应接口
request.interceptors.response.use(response => {
    let res = response.data

    // 返回的文件
    if (response.config.responseType === 'blob') return res;

    // 兼容服务端返回的字符串数据
    if (typeof res === 'string') return res ? JSON.parse(res) : res;

}, error => {
    console.log('response error: ' + error) // 控制台打印错误日志
    return Promise.reject(error)
})

export default request