import { PropTypes } from 'prop-types'
import './Counter.css'

export default function CounterButton({by, incrementMethod, decrementMethod}) {

    // function incrementCounterFunction() { // 각 함수에서 setCounter함수를 정의해준다.
    //     incrementMethod(by);
    // }

    // function decrementCounterFunction() {
    //     decrementMethod(by);
    // }
    
    return (
        <div className="Counter">
            <div>
                <button className="counterButton" 
                        onClick={ () => incrementMethod(by) } // 람다식을 사용해서 부모 메소드를 직접 실행한다.
                >+{by}</button>   
                <button className="counterButton" 
                        onClick={ () => decrementMethod(by) }
                >-{by}</button>
            </div>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}