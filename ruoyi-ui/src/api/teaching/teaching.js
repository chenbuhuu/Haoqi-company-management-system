import request from '@/utils/request'

// 查询讲师代课信息管理列表
export function listTeaching(query) {
  return request({
    url: '/teaching/teaching/list',
    method: 'get',
    params: query
  })
}

// 查询讲师代课信息管理详细
export function getTeaching(id) {
  return request({
    url: '/teaching/teaching/' + id,
    method: 'get'
  })
}

// 新增讲师代课信息管理
export function addTeaching(data) {
  return request({
    url: '/teaching/teaching',
    method: 'post',
    data: data
  })
}

// 修改讲师代课信息管理
export function updateTeaching(data) {
  return request({
    url: '/teaching/teaching',
    method: 'put',
    data: data
  })
}

// 删除讲师代课信息管理
export function delTeaching(id) {
  return request({
    url: '/teaching/teaching/' + id,
    method: 'delete'
  })
}
