export default function InputField({label,type,set}) {
    return(
        <div className={"bg-gray-100 p-5 flex space-x-4 align-center my-5 w-120 rounded-xl "}>
            <label htmlFor={label} className={"text-gray-400 text-xl w-30"}>{label}</label>
            <input type={type} name={label} id={label} onChange={(e) => set(e.target.value)} className={" bg-white p-2 rounded-lg"}/>
        </div>
    )
}