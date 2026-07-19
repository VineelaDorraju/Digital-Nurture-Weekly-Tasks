import { apiClient } from './apiClient'

export const getTodos = () =>
  apiClient('/todos')

export const addTodo = (t:string) =>
  apiClient('/todos',{method:'POST',body:JSON.stringify({t})})