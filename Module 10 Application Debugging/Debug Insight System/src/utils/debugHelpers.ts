let on = true
export const toggle = () => on = !on
export const log = (v:any) => on && console.log(v)