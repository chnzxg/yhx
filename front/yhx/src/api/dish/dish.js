import axios from 'axios'

export function dishList(data) {
  return axios({
    method: 'get',
    url: 'http://localhost:8848/dish/list',
    params: data
  })
}

export function dishDelete(data) {
  return axios({
    method: 'get',
    url: 'http://localhost:8848/dish/delete',
    params: data
  })
}

export function dishUpdate(data) {
  return axios({
    method: 'post',
    url: 'http://localhost:8848/dish/update',
    data: data
  })
}

export function dishCreate(data) {
  return axios({
    method: 'post',
    url: 'http://localhost:8848/dish/create',
    data: data
  })
}
