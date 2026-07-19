import { useState, useEffect } from "react"

export default function Infinite() {
    const [value, setValue] = useState(0)

    useEffect(() => {
        setValue(value + 1)
    })

    return <div>{value}</div>
}