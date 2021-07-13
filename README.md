Challenge : 
1. Implement update endpoint. This endpoint requires @RequestBody as data employee and @PathVariable as id employee to be update.
```
Algorithm : 
- Mapping Request in Controller
- Passing parameter id and employee to service and doing some validation if data is exist.
- If data not exist, throw BusinessException with code DATA_NOT_EXIST.
- else overwrite existing data with new input data.
```
2. Implement delete endpoint. This endpoint requires @PathVariable as id employee to be deleted.
```
Algorithm : 
- Mapping Request in Controller
- Passing parameter id if data is exist.
- If data not exist, throw BusinessException with code DATA_NOT_EXIST.
- else delete data in the hashMap in repository layer.
```

Extra Challenge to understand why we separating request, response and entity: 
1. Try to hide the salary response to 0, because salary is confidential (this logic can be implement in EmployeeResponse salary getter method).
2. Try to create internal variable in Employee entity to store net salary with simple logic (salary - (salary * 10%)), this logic can be done in service layer.

Extra Challenge to understand why the endpoint need have versioning path (eg: v1/employee, v2/employee)
1. Create new endpoint v2/employee with return employee response inside the BaseResponse : 
```
{
    "code": "SUCCESS/DATA_NOT_EXIST/anything",
    "message": "SUCCESS/DATA_NOT_EXIST/anything",
    "errors" : object(can be array, single object or anything)
    "data" : object(can be array, single object or anything)
}
```
*hint : BaseResponse must used generic, eg : BaseResponse<T>, where T can become anything. example : new BaseResponse<Integer>, new BaseResponse<Employee>, new BaseResponse<List<Employee>>, etc.

in real case, when we use versioning API, we can run 2 version of endpoint without having fear of error in the old implemented feature, eg : Android, ios used v1/employee, and desktop used v2/employee.
