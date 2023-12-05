import request from '@/utils/request'

// 查询培训申请管理列表
export function listApplication(query) {
  return request({
    url: '/application/application/list',
    method: 'get',
    params: query
  })
}

// 查询培训申请管理详细
export function getApplication(applicationId) {
  return request({
    url: '/application/application/' + applicationId,
    method: 'get'
  })
}

// 新增培训申请管理
export function addApplication(data) {
  return request({
    url: '/application/application',
    method: 'post',
    data: data
  })
}

// 修改培训申请管理
export function updateApplication(data) {
  return request({
    url: '/application/application',
    method: 'put',
    data: data
  })
}
// 审核
export function commit(data) {
  return request({
    url: '/application/application/commit',
    method: 'put',
    data: data
  })
}

// 删除培训申请管理
export function delApplication(applicationId) {
  return request({
    url: '/application/application/' + applicationId,
    method: 'delete'
  })
}
