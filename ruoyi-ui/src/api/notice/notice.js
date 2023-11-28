import request from '@/utils/request'

// 查询培训通知信息管理列表
export function listNotice(query) {
  return request({
    url: '/notice/notice/list',
    method: 'get',
    params: query
  })
}

// 查询培训通知信息管理详细
export function getNotice(noticeId) {
  return request({
    url: '/notice/notice/' + noticeId,
    method: 'get'
  })
}

// 新增培训通知信息管理
export function addNotice(data) {
  return request({
    url: '/notice/notice',
    method: 'post',
    data: data
  })
}

// 修改培训通知信息管理
export function updateNotice(data) {
  return request({
    url: '/notice/notice',
    method: 'put',
    data: data
  })
}

// 删除培训通知信息管理
export function delNotice(noticeId) {
  return request({
    url: '/notice/notice/' + noticeId,
    method: 'delete'
  })
}
