let realDOM = {
    name: "Vineela",
    age: 20
};
function renderUI(data) {
    console.log(`Name: ${data.name}, Age: ${data.age}`);
}
renderUI(realDOM);
function updateVirtualDOM(newData) {

    console.log("\n Checking changes...");
    let updates = {};

    for (let key in newData) {
        if (newData[key] !== realDOM[key]) {
            updates[key] = newData[key];
        }
    }

    // apply only changes
    if (Object.keys(updates).length > 0) {
        console.log("Updating only changed values:", updates);

        realDOM = { ...realDOM, ...updates }; 
        renderUI(realDOM);
    } else {
        console.log("No changes detected");
    }
}

updateVirtualDOM({ name: "Vineela", age: 21 }); 
updateVirtualDOM({ name: "Vineela", age: 21 }); // no change
updateVirtualDOM({ name: "Anu", age: 21 });     