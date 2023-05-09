import { useState } from 'react';
import './Counter.css'
import CounterButton from './CounterButton';

export default function Counter() {
    const [totalCount, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(totalCount + by);
    }

    function decrementCounterParentFunction(by) {
        setCount(totalCount - by);
    }

    function resetCounter() {
        setCount(0);
    }

    return (
        <div>
            <span className="totalCount">{ totalCount }</span>
            <CounterButton 
                incrementMethod={incrementCounterParentFunction} 
                decrementMethod={ decrementCounterParentFunction }>
            </CounterButton>
            <CounterButton 
                by={2} 
                incrementMethod={incrementCounterParentFunction} 
                decrementMethod={ decrementCounterParentFunction }>
            </CounterButton>
            <CounterButton 
                by={3} 
                incrementMethod={incrementCounterParentFunction} 
                decrementMethod={ decrementCounterParentFunction }>
            </CounterButton>
            <button className='resetButton' onClick={ resetCounter }>reset</button>
        </div>
    )
}
