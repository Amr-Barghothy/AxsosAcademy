export default function Button({number, page, setPage, arr}) {

    const isActive = page === number;

    return (
        <>
            <button
                onClick={() => setPage(number)}
                className={`border-1 p-10 ${isActive ? "bg-black text-white transition-all duration-500" : "bg-white text-black"} `}>
                Tab {number}
            </button>
            {isActive && (
                <textarea name="content" id="content" cols="70" rows="10" value={arr}
                          className={"absolute top-1/2 translate-x-auto -translate-y-1/2 flex border-1 overflow-auto transition-all duration-500"}>
                </textarea>
            )}
        </>
    );
}
