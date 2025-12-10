export default function Box({color, hw}) {
    return (
        <>
            <div style={{backgroundColor: color, height: hw, width: hw} }></div>
        </>
    )
}