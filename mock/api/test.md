FORMAT: 1A
# Jarvis API
测试drakov的数据请求和响应

---
# Group Demo1
demos 资源组
## Demos resp_new [/initWork]
### 初始化任务 [GET]
+ Response 200 (application/json)

{
"code":200,
"msg": "ok",
"data":
{
"count": 10,
"title": "新建任务",
"userWorkList":
[
{"subtitle":"任务1","username":"姓名1"},
{"subtitle":"任务2","username":"姓名2"},
{"subtitle":"任务3","username":"姓名3"}
]
}
}

## Demos resp_submit [/submitWork/{id}]
### 提交任务 [GET]
+ Parameters
        id: 1 (number) - An unique identifier of the message.


+ Response 200 (application/json)
    + Headers
    
        X-My-Message-Header: 42
      
    + Body
    
{
"code":200,
"msg": "ok",
"data":
{
"id": 10,
"title": "提交任务",
"userWorkList":
[
{"subtitle":"任务1","username":"姓名1"},
{"subtitle":"任务2","username":"姓名2"},
{"subtitle":"任务3","username":"姓名3"}
]
}
}

---
# Group Demo2
demo2 资源组
## Demos resp_change [/changeWork]
### 修改任务 [POST]
+ Parameters

    limit (number, optional) - The maximum number of results to return.
        Default: 20

+ Response 200 (application/json)
    + Headers
    
        X-My-Message-Header: 42
        
    + Attributes (object)

        + id: 250FF (string, required)
        
        + created: 1415203908 (number) - Time stamp

        + percent_off: 25 (number)

        A positive integer between 1 and 100 that represents the discount the coupon will apply.

        + redeem_by (number) - Date after which the coupon can no longer be redeemed

    + Body
    
{
"code":200,
"msg": "ok",
"data":
{
"count": 10,
"title": "修改任务",
"userWorkList":
[
{"subtitle":"任务1","username":"姓名1"},
{"subtitle":"任务2","username":"姓名2"},
{"subtitle":"任务3","username":"姓名3"}
]
}
}

## Demos resp_add [/addWork]
### 添加任务 [POST]
+ Parameters

    limit (number, optional) - The maximum number of results to return.
        Default: 20

+ Response 200 (application/json)
    + Headers
    
        X-My-Message-Header: 42

    + Attributes (Coupon Base)

        + id: 250FF (string, required)
        
        + created: 1415203908 (number) - Time stamp


---
# Data Structures
## Coupon Base (object)
+ percent_off: 25 (number)

  A positive integer between 1 and 100 that represents the discount the coupon will apply.

+ redeem_by (number) - Date after which the coupon can no longer be redeemed

---

# Group Demo3
demo3 资源组
## Demos resp_mode [/addmode]

+ Model (application/vnd.siren+json)

    This is the application/vnd.siren+json message resource representation.

    + Body

          {
            "class": [ "message" ],
            "properties": {
                  "message": "Hello World!"
            },
            "links": [
                  { "rel": "self" , "href": "/message" }
            ]
          }



## Demos resp_add_content  [/addcontent]
### 添加内容 [GET]
+ Parameters

    limit (number, optional) - The maximum number of results to return.
        Default: 20

+ Response 200 (application/json)

    [Demos resp_mode][]
    
## Demos resp_change_content [/changecontent{?status,property}]
### 添加参数 [GET]
+ Parameters

    status (number, optional) 
    property(string)
    
+ Response 200 (application/json)

    [Demos resp_mode][]
    
    
    