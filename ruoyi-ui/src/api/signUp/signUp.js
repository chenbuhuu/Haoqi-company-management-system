import request from '@/utils/request'

// 查询学员报名课程列表
export function listSignUp(query) {
  return request({
    url: '/signUp/signUp/list',
    method: 'get',
    params: query
  })
}

// 查询学员报名课程详细
export function getSignUp(deptId) {
  return request({
    url: '/signUp/signUp/' + deptId,
    method: 'get'
  })
}

// 新增学员报名课程
export function addSignUp(data) {
  return request({
    url: '/signUp/signUp',
    method: 'post',
    data: data
  })
}


// 删除学员报名课程
export function delSignUp(deptId) {
  return request({
    url: '/signUp/signUp/' + deptId,
    method: 'delete'
  })
}


// 修改学员报名课程
export function updateSignUp(data) {
  return request({
    url: '/signUp/signUp',
    method: 'put',
    data: data
  })
}

export function searchSuitableCourse(dateRange) {
  console.log("--------")
  console.log(dateRange)
  console.log("--------")

  return request({
    url: '/signUp/signUp/' + dateRange,
    method: 'get'
  })
}

// export function signUp(data) {
//   return request({
//     url: '/signUp/signUp',
//     method: 'post',
//     data:data
//   })
// }
