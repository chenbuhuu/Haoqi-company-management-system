import request from '@/utils/request'

// 查询公司申请培训列表
export function listApply(query) {
  return request({
    url: '/apply/apply/list',
    method: 'get',
    params: query
  })
}

// 查询公司申请培训详细
export function getApply(deptId) {
  return request({
    url: '/apply/apply/' + deptId,
    method: 'get'
  })
}

// 新增公司申请培训
export function addApply(data) {
  return request({
    url: '/apply/apply',
    method: 'post',
    data: data
  })
}

// 修改公司申请培训
export function updateApply(data) {
  return request({
    url: '/apply/apply',
    method: 'put',
    data: data
  })
}

// 删除公司申请培训
export function delApply(deptId) {
  return request({
    url: '/apply/apply/' + deptId,
    method: 'delete'
  })
}


// 删除公司申请培训
export function apply(data) {
  return request({
    url: '/apply/apply',
    method: 'post',
    data: data
  })
}
