import React, {useState} from 'react';

const CheckList = ({taskName,index,arr,setTasks}) => {
    const [checked, setChecked] = useState(false)

    const handleDelete = () => {
        console.log(arr)
        setTasks(prev => prev.filter((_,idx) => idx !== index))
        console.log(arr)

    }
    return (
        <div className={"mx-auto w-20/100 mt-10 space-x-4"}>
            <label className={`${checked? "line-through" : "no-underline"}`}>
                {taskName}
                <input  type="checkbox" name="task" id="task" checked={checked} onChange={() => setChecked(!checked)}/>
            </label>
            <button className={"bg-black p-4 text-white"} onClick={handleDelete}>Delete</button>
        </div>
    );
};

export default CheckList;