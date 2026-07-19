class DebugStore {
  private stack:{msg:string;stamp:number}[] = []

  log(msg:string){
    this.stack.unshift({ msg, stamp: Date.now() })
  }

  list(){
    return this.stack
  }
}

export default new DebugStore()