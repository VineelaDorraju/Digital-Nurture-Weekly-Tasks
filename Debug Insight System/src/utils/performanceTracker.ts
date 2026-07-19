export const measure = <T>(fn:()=>T) => {
  const s = performance.now()
  const r = fn()
  console.log(performance.now() - s)
  return r
}