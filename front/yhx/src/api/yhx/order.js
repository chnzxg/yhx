import axios from 'axios'
import settings from '../../settings'

export function orderList(data) {
  return axios({
    method: 'get',
    url: settings.props.host + '/order/list',
    params: data
  })
}

export function orderDelete(data) {
  return axios({
    method: 'get',
    url: settings.props.host + '/order/delete',
    params: data
  })
}

export function orderUpdate(data) {
  return axios({
    method: 'post',
    url: settings.props.host + '/order/update',
    data: data
  })
}

export function orderCreate(data) {
  return axios({
    method: 'post',
    url: settings.props.host + '/order/create',
    data: data
  })
}

export function orderGet(data) {
  return axios({
    method: 'get',
    url: settings.props.host + '/order/create',
    params: data
  })
}
