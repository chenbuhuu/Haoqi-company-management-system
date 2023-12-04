import request from '@/utils/request'

// 查询学员上课信息管理列表
export function listStudying(query) {
  return request({
    url: '/studying/studying/list',
    method: 'get',
    params: query
  })
}

// 查询学员上课信息管理详细
export function getStudying(id) {
  return request({
    url: '/studying/studying/' + id,
    method: 'get'
  })
}

// 新增学员上课信息管理
export function addStudying(data) {
  return request({
    url: '/studying/studying',
    method: 'post',
    data: data
  })
}

// 修改学员上课信息管理
export function updateStudying(data) {
  return request({
    url: '/studying/studying',
    method: 'put',
    data: data
  })
}
// 缴费
export function pay(data) {
  return request({
    url: '/studying/studying/pay',
    method: 'put',
    data: data
  })
}

// 报名
export function signIn(data) {
  return request({
    url: '/studying/studying/sign',
    method: 'put',
    data: data
  })
}

// 删除学员上课信息管理
export function delStudying(id) {
  return request({
    url: '/studying/studying/' + id,
    method: 'delete'
  })
}
