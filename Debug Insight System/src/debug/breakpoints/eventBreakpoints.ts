export const onKey = (key:string) => {
  window.addEventListener('keydown', e => {
    if(e.key === key) debugger
  })
}