import request from '@/utils/request'

// 查询讲师信息管理列表
export function listTeacher(query) {
  return request({
    url: '/teacher/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询讲师信息管理详细
export function getTeacher(teacherId) {
  return request({
    url: '/teacher/teacher/' + teacherId,
    method: 'get'
  })
}

// 新增讲师信息管理
export function addTeacher(data) {
  return request({
    url: '/teacher/teacher',
    method: 'post',
    data: data
  })
}

// 修改讲师信息管理
export function updateTeacher(data) {
  return request({
    url: '/teacher/teacher',
    method: 'put',
    data: data
  })
}

// 删除讲师信息管理
export function delTeacher(teacherId) {
  return request({
    url: '/teacher/teacher/' + teacherId,
    method: 'delete'
  })
}
