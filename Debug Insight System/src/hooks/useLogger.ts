export const useLogger = () => {
  return (msg:string) => {
    console.log(Date.now(), msg)
  }
}