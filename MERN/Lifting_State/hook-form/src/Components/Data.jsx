export default function Data({label,get}) {
    return (
        <div className={"flex space-x-4 w-130"}>
            <p className={"text-lg"}>{label}</p>
            <p className={"text-lg"}>{get}</p>
        </div>
    )
}