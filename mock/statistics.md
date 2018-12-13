FORMAT: 1A
# Example API
statistics
## 统计 [/statistics]
### 获取统计数据 [GET]
+ Response 200 (application/json)
+
{
            "success": true, 
            "err_code": "888888", 
            "err_msg": "错误说明",
            "data": [{
                "hour": "2016-10-31",
                "totalIncome": "1000.09",
                "totalRefund": "100.08",
                "incomeOrders": 70,
                "refundOrders": 10,
                "totalOrders": 80
            }]
 }