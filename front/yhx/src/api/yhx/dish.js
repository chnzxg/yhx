import axios from 'axios'
import settings from '../../settings'

export function dishList(data) {
  return axios({
    method: 'get',
    url: settings.props.host + '/dish/list',
    params: data
  })
}

export function dishDelete(data) {
  return axios({
    method: 'get',
    url: settings.props.host + '/dish/delete',
    params: data
  })
}

export function dishUpdate(data) {
  return axios({
    method: 'post',
    url: settings.props.host + '/dish/update',
    data: data
  })
}

export function dishCreate(data) {
  return axios({
    method: 'post',
    url: settings.props.host + '/dish/create',
    data: data
  })
}
