class Store {
  private n = 0

  increment(){
    this.n++
  }

  value(){
    return this.n
  }
}

export default new Store()