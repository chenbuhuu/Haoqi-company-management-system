import request from '@/utils/request'

// 查询课程计划管理列表
export function listCourse(query) {
  return request({
    url: '/course/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程计划管理详细
export function getCourse(courseId) {
  return request({
    url: '/course/course/' + courseId,
    method: 'get'
  })
}

// 新增课程计划管理
export function addCourse(data) {
  return request({
    url: '/course/course',
    method: 'post',
    data: data
  })
}

// 修改课程计划管理
export function updateCourse(data) {
  return request({
    url: '/course/course',
    method: 'put',
    data: data
  })
}

// 删除课程计划管理
export function delCourse(courseId) {
  return request({
    url: '/course/course/' + courseId,
    method: 'delete'
  })
}
