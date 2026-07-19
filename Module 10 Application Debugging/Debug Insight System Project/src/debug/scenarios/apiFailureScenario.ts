export const load = async (u:string,n=2):Promise<any> => {
  while(n--){
    try{
      const r=await fetch(u)
      if(r.ok) return r.json()
    }catch{}
  }
  return null
}