module.exports = {
    sourceFiles: './api/*.md', // 指定 API 描述文件
    watch: true, // 监视 API 描述文件的改动并自动加载
    public: true // 打开这个选项，就可以通过 IP 来访问接口
};